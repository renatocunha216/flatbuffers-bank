//============================================================================
// Name        : main.cpp
// Author      : RBC
// Version     :
// Copyright   : Your copyright notice
// Description : 
//============================================================================

//#include "flatbuffers/flatbuffers.h"
#include "flatbuffers_common_reader.h"
#include "flatbuffers_common_builder.h"
#include "BankTransactions_reader.h"
#include "BankTransactions_builder.h"
#include "BankTransactions_verifier.h"
#include "Common_reader.h"
#include "Common_builder.h"
#include "Common_verifier.h"
#include "model/Bank_types.h"

#include <stdio.h>
#include <stdint.h>

#undef ns
#define ns(x) FLATBUFFERS_WRAP_NAMESPACE(flatbuffers, x) // Specified in the schema.

void loadBanks(Bank* bank) {
	Bank b = {code: 9313, name: "ABN AMRO S.A."};
}


int main() {

	//AllBanks banks;

    printf("Hello Flatbuffers!");

    uint8_t *buf;
    size_t size;
    flatcc_builder_t builder;
    flatcc_builder_t* B;

    // Initialize the builder object.
    B = &builder;
    flatcc_builder_init(B);

	ns(DateTimeFbs_create(B, 1, 2, 3, 4 , 5 , 6));

	// TODO: .....


    free(buf);
	flatcc_builder_clear(B);

    return 0;
}
