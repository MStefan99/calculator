package com.annushkaproject.programmerscalculator.model;
public enum int_size_enum {l8, l4, l2, l1;
 public int wordToInt() {
  switch (this) { case l8: return 0; case l4: return 1; case l2: return 2; case l1: return 3; default: return -1; }
 }
 public static int_size_enum intToWord(int number) {
  switch (number) { default: case 0:  return l8; case 1:  return l4; case 2:  return l2; case 3:  return l1;   } }
}
