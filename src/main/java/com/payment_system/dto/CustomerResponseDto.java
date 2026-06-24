package com.payment_system.dto;

import java.time.LocalDate;
import java.util.Set;

public record CustomerResponseDto(
        String object,
        boolean hasMore,
        int totalCount,
        int limit,
        int offset,
        Set<Data> data
) {

    public record Data(
            String object,
            String id,
            LocalDate dateCreated,
            String name,
            String email,
            String phone,
            String mobilePhone,
            String address,
            String addressNumber,
            String complement,
            String province,
            int city,
            String cityName,
            String state,
            String country,
            String postalCode,
            String cpfCnpj,
            String personType,
            boolean deleted,
            String additionalEmails,
            String company,
            String municipalInscription,
            String stateInscription,
            String canDelete,
            String cannotBeDeletedReason,
            String canEdit,
            String cannotEditReason,
            String externalReference,
            String notificationDisabled,
            String observations,
            boolean foreignCustomer
    ) {}
}
