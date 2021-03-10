package com.annushkaproject.programmerscalculator.model;
public enum int_size_enum {
 int_size_enum_kvrd, int_size_enum_dvrd, int_size_enum_vrd, int_size_enum_byte;
 public int wordToInt() {
  switch (this) {
   case int_size_enum_kvrd:     return 0;
   case int_size_enum_dvrd: return 1;
   case int_size_enum_vrd: return 2;
   case int_size_enum_byte: return 3;
   default: return -1;
  }
 }
 public static int_size_enum intToWord(int number) {
  switch (number) {
   default: case 0:  return int_size_enum_kvrd; case 1:  return int_size_enum_dvrd;
   case 2:  return int_size_enum_vrd; case 3:  return int_size_enum_byte;   }
 }
}
