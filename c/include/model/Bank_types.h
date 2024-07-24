/*
 * Bank_types.h
 *
 *  Created on: 23 de jul. de 2024
 *      Author: Renato Cunha
 */

#ifndef INCLUDE_MODEL_BANK_TYPES_H_
#define INCLUDE_MODEL_BANK_TYPES_H_

#define TOTAL_BANKS  9

typedef struct {
	uint32_t code;
	char name[20];
} Bank;

Bank allBanks[TOTAL_BANKS] = {
		{9313, "ABN AMRO S.A."},
		{1, "Banco do Brasil"},
		{4041, "Banrisul"},
		{5237, "Bradesco"},
		{745, "Citibank"},
		{4048, "Itau"},
		{7376, "J.P. Morgan S.A."},
		{260, "Nubank"},
		{3008, "Santander"}
};

#endif /* INCLUDE_MODEL_BANK_TYPES_H_ */
