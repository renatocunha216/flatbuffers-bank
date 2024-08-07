#ifndef COMMON_BUILDER_H
#define COMMON_BUILDER_H

/* Generated by flatcc 0.6.1 FlatBuffers schema compiler for C by dvide.com */

#ifndef COMMON_READER_H
#include "Common_reader.h"
#endif
#ifndef FLATBUFFERS_COMMON_BUILDER_H
#include "flatbuffers_common_builder.h"
#endif
#include "flatcc/flatcc_prologue.h"
#ifndef flatbuffers_identifier
#define flatbuffers_identifier 0
#endif
#ifndef flatbuffers_extension
#define flatbuffers_extension "bin"
#endif

#define __flatbuffers_DateTimeFbs_formal_args ,\
  uint8_t v0, uint8_t v1, uint16_t v2, uint8_t v3, uint8_t v4, uint8_t v5
#define __flatbuffers_DateTimeFbs_call_args ,\
  v0, v1, v2, v3, v4, v5
static inline flatbuffers_DateTimeFbs_t *flatbuffers_DateTimeFbs_assign(flatbuffers_DateTimeFbs_t *p,
  uint8_t v0, uint8_t v1, uint16_t v2, uint8_t v3, uint8_t v4, uint8_t v5)
{ p->day = v0; p->month = v1; p->year = v2; p->hour = v3;
  p->minute = v4; p->second = v5;
  return p; }
static inline flatbuffers_DateTimeFbs_t *flatbuffers_DateTimeFbs_copy(flatbuffers_DateTimeFbs_t *p, const flatbuffers_DateTimeFbs_t *p2)
{ p->day = p2->day; p->month = p2->month; p->year = p2->year; p->hour = p2->hour;
  p->minute = p2->minute; p->second = p2->second;
  return p; }
static inline flatbuffers_DateTimeFbs_t *flatbuffers_DateTimeFbs_assign_to_pe(flatbuffers_DateTimeFbs_t *p,
  uint8_t v0, uint8_t v1, uint16_t v2, uint8_t v3, uint8_t v4, uint8_t v5)
{ p->day = v0; p->month = v1; flatbuffers_uint16_assign_to_pe(&p->year, v2); p->hour = v3;
  p->minute = v4; p->second = v5;
  return p; }
static inline flatbuffers_DateTimeFbs_t *flatbuffers_DateTimeFbs_copy_to_pe(flatbuffers_DateTimeFbs_t *p, const flatbuffers_DateTimeFbs_t *p2)
{ p->day = p2->day; p->month = p2->month; flatbuffers_uint16_copy_to_pe(&p->year, &p2->year); p->hour = p2->hour;
  p->minute = p2->minute; p->second = p2->second;
  return p; }
static inline flatbuffers_DateTimeFbs_t *flatbuffers_DateTimeFbs_assign_from_pe(flatbuffers_DateTimeFbs_t *p,
  uint8_t v0, uint8_t v1, uint16_t v2, uint8_t v3, uint8_t v4, uint8_t v5)
{ p->day = v0; p->month = v1; flatbuffers_uint16_assign_from_pe(&p->year, v2); p->hour = v3;
  p->minute = v4; p->second = v5;
  return p; }
static inline flatbuffers_DateTimeFbs_t *flatbuffers_DateTimeFbs_copy_from_pe(flatbuffers_DateTimeFbs_t *p, const flatbuffers_DateTimeFbs_t *p2)
{ p->day = p2->day; p->month = p2->month; flatbuffers_uint16_copy_from_pe(&p->year, &p2->year); p->hour = p2->hour;
  p->minute = p2->minute; p->second = p2->second;
  return p; }
__flatbuffers_build_struct(flatbuffers_, flatbuffers_DateTimeFbs, 8, 2, flatbuffers_DateTimeFbs_file_identifier, flatbuffers_DateTimeFbs_type_identifier)
__flatbuffers_define_fixed_array_primitives(flatbuffers_, flatbuffers_DateTimeFbs, flatbuffers_DateTimeFbs_t)

#include "flatcc/flatcc_epilogue.h"
#endif /* COMMON_BUILDER_H */
