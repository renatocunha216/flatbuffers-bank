#ifndef BANKTRANSACTIONS_READER_H
#define BANKTRANSACTIONS_READER_H

/* Generated by flatcc 0.6.1 FlatBuffers schema compiler for C by dvide.com */

#ifndef FLATBUFFERS_COMMON_READER_H
#include "flatbuffers_common_reader.h"
#endif
#ifndef COMMON_READER_H
#include "Common_reader.h"
#endif
#include "flatcc/flatcc_flatbuffers.h"
#ifndef __alignas_is_defined
#include <stdalign.h>
#endif
#include "flatcc/flatcc_prologue.h"
#undef flatbuffers_identifier
#define flatbuffers_identifier "BANK"
#undef flatbuffers_extension
#define flatbuffers_extension "bin"

typedef struct flatbuffers_AuthenticationCodeFbs flatbuffers_AuthenticationCodeFbs_t;
typedef const flatbuffers_AuthenticationCodeFbs_t *flatbuffers_AuthenticationCodeFbs_struct_t;
typedef flatbuffers_AuthenticationCodeFbs_t *flatbuffers_AuthenticationCodeFbs_mutable_struct_t;
typedef const flatbuffers_AuthenticationCodeFbs_t *flatbuffers_AuthenticationCodeFbs_vec_t;
typedef flatbuffers_AuthenticationCodeFbs_t *flatbuffers_AuthenticationCodeFbs_mutable_vec_t;

typedef const struct flatbuffers_BankFbs_table *flatbuffers_BankFbs_table_t;
typedef struct flatbuffers_BankFbs_table *flatbuffers_BankFbs_mutable_table_t;
typedef const flatbuffers_uoffset_t *flatbuffers_BankFbs_vec_t;
typedef flatbuffers_uoffset_t *flatbuffers_BankFbs_mutable_vec_t;
typedef const struct flatbuffers_BankAccountFbs_table *flatbuffers_BankAccountFbs_table_t;
typedef struct flatbuffers_BankAccountFbs_table *flatbuffers_BankAccountFbs_mutable_table_t;
typedef const flatbuffers_uoffset_t *flatbuffers_BankAccountFbs_vec_t;
typedef flatbuffers_uoffset_t *flatbuffers_BankAccountFbs_mutable_vec_t;
typedef const struct flatbuffers_FundTransferFbs_table *flatbuffers_FundTransferFbs_table_t;
typedef struct flatbuffers_FundTransferFbs_table *flatbuffers_FundTransferFbs_mutable_table_t;
typedef const flatbuffers_uoffset_t *flatbuffers_FundTransferFbs_vec_t;
typedef flatbuffers_uoffset_t *flatbuffers_FundTransferFbs_mutable_vec_t;
typedef const struct flatbuffers_BankTransactionFbs_table *flatbuffers_BankTransactionFbs_table_t;
typedef struct flatbuffers_BankTransactionFbs_table *flatbuffers_BankTransactionFbs_mutable_table_t;
typedef const flatbuffers_uoffset_t *flatbuffers_BankTransactionFbs_vec_t;
typedef flatbuffers_uoffset_t *flatbuffers_BankTransactionFbs_mutable_vec_t;
#ifndef flatbuffers_BankFbs_file_identifier
#define flatbuffers_BankFbs_file_identifier "BANK"
#endif
/* deprecated, use flatbuffers_BankFbs_file_identifier */
#ifndef flatbuffers_BankFbs_identifier
#define flatbuffers_BankFbs_identifier "BANK"
#endif
#define flatbuffers_BankFbs_type_hash ((flatbuffers_thash_t)0x7dbc6e4)
#define flatbuffers_BankFbs_type_identifier "\xe4\xc6\xdb\x07"
#ifndef flatbuffers_BankFbs_file_extension
#define flatbuffers_BankFbs_file_extension "bin"
#endif
#ifndef flatbuffers_BankAccountFbs_file_identifier
#define flatbuffers_BankAccountFbs_file_identifier "BANK"
#endif
/* deprecated, use flatbuffers_BankAccountFbs_file_identifier */
#ifndef flatbuffers_BankAccountFbs_identifier
#define flatbuffers_BankAccountFbs_identifier "BANK"
#endif
#define flatbuffers_BankAccountFbs_type_hash ((flatbuffers_thash_t)0xdb0cd727)
#define flatbuffers_BankAccountFbs_type_identifier "\x27\xd7\x0c\xdb"
#ifndef flatbuffers_BankAccountFbs_file_extension
#define flatbuffers_BankAccountFbs_file_extension "bin"
#endif
#ifndef flatbuffers_AuthenticationCodeFbs_file_identifier
#define flatbuffers_AuthenticationCodeFbs_file_identifier "BANK"
#endif
/* deprecated, use flatbuffers_AuthenticationCodeFbs_file_identifier */
#ifndef flatbuffers_AuthenticationCodeFbs_identifier
#define flatbuffers_AuthenticationCodeFbs_identifier "BANK"
#endif
#define flatbuffers_AuthenticationCodeFbs_type_hash ((flatbuffers_thash_t)0xce4d6d5)
#define flatbuffers_AuthenticationCodeFbs_type_identifier "\xd5\xd6\xe4\x0c"
#ifndef flatbuffers_AuthenticationCodeFbs_file_extension
#define flatbuffers_AuthenticationCodeFbs_file_extension "bin"
#endif
#ifndef flatbuffers_FundTransferFbs_file_identifier
#define flatbuffers_FundTransferFbs_file_identifier "BANK"
#endif
/* deprecated, use flatbuffers_FundTransferFbs_file_identifier */
#ifndef flatbuffers_FundTransferFbs_identifier
#define flatbuffers_FundTransferFbs_identifier "BANK"
#endif
#define flatbuffers_FundTransferFbs_type_hash ((flatbuffers_thash_t)0x542c6dd2)
#define flatbuffers_FundTransferFbs_type_identifier "\xd2\x6d\x2c\x54"
#ifndef flatbuffers_FundTransferFbs_file_extension
#define flatbuffers_FundTransferFbs_file_extension "bin"
#endif
#ifndef flatbuffers_BankTransactionFbs_file_identifier
#define flatbuffers_BankTransactionFbs_file_identifier "BANK"
#endif
/* deprecated, use flatbuffers_BankTransactionFbs_file_identifier */
#ifndef flatbuffers_BankTransactionFbs_identifier
#define flatbuffers_BankTransactionFbs_identifier "BANK"
#endif
#define flatbuffers_BankTransactionFbs_type_hash ((flatbuffers_thash_t)0x218eb3fe)
#define flatbuffers_BankTransactionFbs_type_identifier "\xfe\xb3\x8e\x21"
#ifndef flatbuffers_BankTransactionFbs_file_extension
#define flatbuffers_BankTransactionFbs_file_extension "bin"
#endif

typedef int8_t flatbuffers_Status_enum_t;
__flatbuffers_define_integer_type(flatbuffers_Status, flatbuffers_Status_enum_t, 8)
#define flatbuffers_Status_PENDING ((flatbuffers_Status_enum_t)INT8_C(0))
#define flatbuffers_Status_CONFIRMED ((flatbuffers_Status_enum_t)INT8_C(1))
#define flatbuffers_Status_CANCELED ((flatbuffers_Status_enum_t)INT8_C(2))

static inline const char *flatbuffers_Status_name(flatbuffers_Status_enum_t value)
{
    switch (value) {
    case flatbuffers_Status_PENDING: return "PENDING";
    case flatbuffers_Status_CONFIRMED: return "CONFIRMED";
    case flatbuffers_Status_CANCELED: return "CANCELED";
    default: return "";
    }
}

static inline int flatbuffers_Status_is_known_value(flatbuffers_Status_enum_t value)
{
    switch (value) {
    case flatbuffers_Status_PENDING: return 1;
    case flatbuffers_Status_CONFIRMED: return 1;
    case flatbuffers_Status_CANCELED: return 1;
    default: return 0;
    }
}


struct flatbuffers_AuthenticationCodeFbs {
    alignas(1) int8_t value[16];
};
static_assert(sizeof(flatbuffers_AuthenticationCodeFbs_t) == 16, "struct size mismatch");

static inline const flatbuffers_AuthenticationCodeFbs_t *flatbuffers_AuthenticationCodeFbs__const_ptr_add(const flatbuffers_AuthenticationCodeFbs_t *p, size_t i) { return p + i; }
static inline flatbuffers_AuthenticationCodeFbs_t *flatbuffers_AuthenticationCodeFbs__ptr_add(flatbuffers_AuthenticationCodeFbs_t *p, size_t i) { return p + i; }
static inline flatbuffers_AuthenticationCodeFbs_struct_t flatbuffers_AuthenticationCodeFbs_vec_at(flatbuffers_AuthenticationCodeFbs_vec_t vec, size_t i)
__flatbuffers_struct_vec_at(vec, i)
static inline size_t flatbuffers_AuthenticationCodeFbs__size(void) { return 16; }
static inline size_t flatbuffers_AuthenticationCodeFbs_vec_len(flatbuffers_AuthenticationCodeFbs_vec_t vec)
__flatbuffers_vec_len(vec)
__flatbuffers_struct_as_root(flatbuffers_AuthenticationCodeFbs)

__flatbuffers_define_struct_scalar_fixed_array_field(flatbuffers_AuthenticationCodeFbs, value, flatbuffers_int8, int8_t, 16)


struct flatbuffers_BankFbs_table { uint8_t unused__; };

static inline size_t flatbuffers_BankFbs_vec_len(flatbuffers_BankFbs_vec_t vec)
__flatbuffers_vec_len(vec)
static inline flatbuffers_BankFbs_table_t flatbuffers_BankFbs_vec_at(flatbuffers_BankFbs_vec_t vec, size_t i)
__flatbuffers_offset_vec_at(flatbuffers_BankFbs_table_t, vec, i, 0)
__flatbuffers_table_as_root(flatbuffers_BankFbs)

__flatbuffers_define_string_field(0, flatbuffers_BankFbs, name, 0)
__flatbuffers_define_scalar_field(1, flatbuffers_BankFbs, bank_code, flatbuffers_int32, int32_t, INT32_C(0))

struct flatbuffers_BankAccountFbs_table { uint8_t unused__; };

static inline size_t flatbuffers_BankAccountFbs_vec_len(flatbuffers_BankAccountFbs_vec_t vec)
__flatbuffers_vec_len(vec)
static inline flatbuffers_BankAccountFbs_table_t flatbuffers_BankAccountFbs_vec_at(flatbuffers_BankAccountFbs_vec_t vec, size_t i)
__flatbuffers_offset_vec_at(flatbuffers_BankAccountFbs_table_t, vec, i, 0)
__flatbuffers_table_as_root(flatbuffers_BankAccountFbs)

__flatbuffers_define_scalar_field(0, flatbuffers_BankAccountFbs, account_number, flatbuffers_int32, int32_t, INT32_C(0))
__flatbuffers_define_scalar_field(1, flatbuffers_BankAccountFbs, check_digit, flatbuffers_uint8, uint8_t, UINT8_C(0))

struct flatbuffers_FundTransferFbs_table { uint8_t unused__; };

static inline size_t flatbuffers_FundTransferFbs_vec_len(flatbuffers_FundTransferFbs_vec_t vec)
__flatbuffers_vec_len(vec)
static inline flatbuffers_FundTransferFbs_table_t flatbuffers_FundTransferFbs_vec_at(flatbuffers_FundTransferFbs_vec_t vec, size_t i)
__flatbuffers_offset_vec_at(flatbuffers_FundTransferFbs_table_t, vec, i, 0)
__flatbuffers_table_as_root(flatbuffers_FundTransferFbs)

__flatbuffers_define_struct_field(0, flatbuffers_FundTransferFbs, transfer_date, flatbuffers_DateTimeFbs_struct_t, 0)
__flatbuffers_define_table_field(1, flatbuffers_FundTransferFbs, source_bank, flatbuffers_BankFbs_table_t, 0)
__flatbuffers_define_table_field(2, flatbuffers_FundTransferFbs, source_bank_account, flatbuffers_BankAccountFbs_table_t, 0)
__flatbuffers_define_table_field(3, flatbuffers_FundTransferFbs, destination_bank, flatbuffers_BankFbs_table_t, 0)
__flatbuffers_define_table_field(4, flatbuffers_FundTransferFbs, destination_bank_account, flatbuffers_BankAccountFbs_table_t, 0)
__flatbuffers_define_scalar_field(5, flatbuffers_FundTransferFbs, fee_amount, flatbuffers_float, float, 0.00000000f)
__flatbuffers_define_scalar_field(6, flatbuffers_FundTransferFbs, amount_transfer, flatbuffers_double, double, 0.0000000000000000)
__flatbuffers_define_scalar_field(7, flatbuffers_FundTransferFbs, status, flatbuffers_Status, flatbuffers_Status_enum_t, INT8_C(0))
__flatbuffers_define_struct_field(8, flatbuffers_FundTransferFbs, authentication_code, flatbuffers_AuthenticationCodeFbs_struct_t, 0)

struct flatbuffers_BankTransactionFbs_table { uint8_t unused__; };

static inline size_t flatbuffers_BankTransactionFbs_vec_len(flatbuffers_BankTransactionFbs_vec_t vec)
__flatbuffers_vec_len(vec)
static inline flatbuffers_BankTransactionFbs_table_t flatbuffers_BankTransactionFbs_vec_at(flatbuffers_BankTransactionFbs_vec_t vec, size_t i)
__flatbuffers_offset_vec_at(flatbuffers_BankTransactionFbs_table_t, vec, i, 0)
__flatbuffers_table_as_root(flatbuffers_BankTransactionFbs)

__flatbuffers_define_vector_field(0, flatbuffers_BankTransactionFbs, transactions, flatbuffers_FundTransferFbs_vec_t, 0)


#include "flatcc/flatcc_epilogue.h"
#endif /* BANKTRANSACTIONS_READER_H */