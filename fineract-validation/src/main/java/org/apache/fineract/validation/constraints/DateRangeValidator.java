/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.validation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String dateField;
    private String formatField;
    private String localeField;
    private int maxYearsAgo;

    @Override
    public void initialize(DateRange annotation) {
        this.dateField = annotation.dateField();
        this.formatField = annotation.formatField();
        this.localeField = annotation.localeField();
        this.maxYearsAgo = annotation.maxYearsAgo();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            var clazz = value.getClass();
            var dateFieldVal = (String) getFieldValue(clazz, value, dateField);
            var format = (String) getFieldValue(clazz, value, formatField);
            var locale = (String) getFieldValue(clazz, value, localeField);

            if (StringUtils.isBlank(dateFieldVal) || StringUtils.isBlank(format) || StringUtils.isBlank(locale)) {
                return true;
            }

            var formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(format.replace("y", "u"))
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter(java.util.Locale.forLanguageTag(locale))
                    .withResolverStyle(ResolverStyle.STRICT);

            java.time.LocalDate parsedDate = java.time.LocalDate.parse(dateFieldVal, formatter);
            java.time.LocalDate today = java.time.LocalDate.now();

            // Date must not be in future and must be at most {specified} years old
            return !parsedDate.isAfter(today) && !parsedDate.isBefore(today.minusYears(maxYearsAgo));

        } catch (Exception e) {
            return false;
        }
    }

    private Object getFieldValue(Class<?> clazz, Object obj, String fieldName) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
