package org.apache.fineract.organisation.monetary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CreateCurrencyRepository extends JpaRepository<CreateCurrency, Long>, JpaSpecificationExecutor<CreateCurrency> {

}
