package org.apache.fineract.portfolio.loanaccount.guarantor.mapper;

import java.util.UUID;
import org.apache.fineract.infrastructure.core.service.DateUtils;
import org.apache.fineract.portfolio.loanaccount.guarantor.command.CreateGuarantorsCommand;
import org.apache.fineract.portfolio.loanaccount.guarantor.command.DeleteGuarantorsCommand;
import org.apache.fineract.portfolio.loanaccount.guarantor.command.UpdateGuarantorsCommand;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.CreateGuarantorsRequest;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.DeleteGuarantorsRequest;
import org.apache.fineract.portfolio.loanaccount.guarantor.data.UpdateGuarantorsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = { UUID.class, DateUtils.class })
public interface GuarantorCommandMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(DateUtils.getAuditOffsetDateTime())")
    @Mapping(target = "payload", expression = "java(toPayload(loanId, request))")
    CreateGuarantorsCommand toCommand(Long loanId, CreateGuarantorsRequest request);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(DateUtils.getAuditOffsetDateTime())")
    @Mapping(target = "payload", expression = "java(toPayload(loanId, guarantorId, request))")
    UpdateGuarantorsCommand toCommand(Long loanId, Long guarantorId, UpdateGuarantorsRequest request);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "createdAt", expression = "java(DateUtils.getAuditOffsetDateTime())")
    @Mapping(target = "payload", expression = "java(toPayload(loanId, guarantorId, guarantorFundingId))")
    DeleteGuarantorsCommand toCommand(Long loanId, Long guarantorId, Long guarantorFundingId);

    // Default method for filling loanId if missing
    default CreateGuarantorsRequest toPayload(Long loanId, CreateGuarantorsRequest request) {
        return CreateGuarantorsRequest.builder().loanId(request.getLoanId() != null ? request.getLoanId() : loanId)
                .locale(request.getLocale()).dateFormat(request.getDateFormat())
                .clientRelationshipTypeId(request.getClientRelationshipTypeId()).guarantorTypeId(request.getGuarantorTypeId())
                .entityId(request.getEntityId()).firstname(request.getFirstname()).lastname(request.getLastname())
                .addressLine1(request.getAddressLine1()).addressLine2(request.getAddressLine2()).city(request.getCity())
                .state(request.getState()).zip(request.getZip()).country(request.getCountry()).mobileNumber(request.getMobileNumber())
                .housePhoneNumber(request.getHousePhoneNumber()).comment(request.getComment()).dob(request.getDob())
                .savingsId(request.getSavingsId()).amount(request.getAmount()).build();
    }

    // Default method for filling loanId if missing
    default UpdateGuarantorsRequest toPayload(Long loanId, Long guarantorId, UpdateGuarantorsRequest request) {
        return UpdateGuarantorsRequest.builder().loanId(request.getLoanId() != null ? request.getLoanId() : loanId)
                .guarantorId(request.getGuarantorId() != null ? request.getGuarantorId() : guarantorId).locale(request.getLocale())
                .dateFormat(request.getDateFormat()).clientRelationshipTypeId(request.getClientRelationshipTypeId())
                .guarantorTypeId(request.getGuarantorTypeId()).entityId(request.getEntityId()).firstname(request.getFirstname())
                .lastname(request.getLastname()).addressLine1(request.getAddressLine1()).addressLine2(request.getAddressLine2())
                .city(request.getCity()).state(request.getState()).zip(request.getZip()).country(request.getCountry())
                .mobileNumber(request.getMobileNumber()).housePhoneNumber(request.getHousePhoneNumber()).comment(request.getComment())
                .dob(request.getDob()).savingsId(request.getSavingsId()).amount(request.getAmount()).build();
    }

    // helper to build payload
    default DeleteGuarantorsRequest toPayload(Long loanId, Long guarantorId, Long guarantorFundingId) {
        return DeleteGuarantorsRequest.builder().loanId(loanId).guarantorId(guarantorId).guarantorFundingId(guarantorFundingId).build();
    }
}
