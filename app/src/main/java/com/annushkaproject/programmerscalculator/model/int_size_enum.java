package com.annushkaproject.programmerscalculator.model;
public enum int_size_enum {
 len8, len4, len2, len1;
 public int wordToInt() {
  switch (this) {
   case len8: return 0; case len4: return 1; case len2: return 2; case len1: return 3;
   default: return -1;
  }
 }
 public static int_size_enum intToWord(int number) {
  switch (number) {
   default: case 0:  return len8; case 1:  return len4;
   case 2:  return len2; case 3:  return len1;   }
 }
}
