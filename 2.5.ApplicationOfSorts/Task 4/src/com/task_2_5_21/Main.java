package com.task_2_5_21;

public class Main {

  public static void main(String[] args) {
    Vector[] vectors = {
        new Vector(1, 2, 3),
        new Vector(3, 2, 1),
        new Vector(2, 1, 3),
        new Vector(1, 3, 2),
        new Vector(2, 3, 1) };
    MergeSort.sort(vectors);

    System.out.println("Отсортированные вектора: ");

    for (Vector v : vectors) {
      System.out.println(v.toString());
    }
  }
}