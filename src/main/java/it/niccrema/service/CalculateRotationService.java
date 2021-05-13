package it.niccrema.service;

public class CalculateRotationService {
  public static int shiftedDiff(String first, String second) {
    int rotations = 0;
    boolean validRotation = false;
    String stringToShift = first;

    if (first == null || second == null) {
      throw new RuntimeException("Invalid arguments");
    }

    if (first.equals(second)) {
      validRotation = true;
    } else {

      for (int i = 0; i < second.length(); i++) {

        String shiftedString = shift(stringToShift);
        rotations++;

        if (shiftedString.equals(second)) {
          validRotation = true;
          break;
        }

        stringToShift = shiftedString;
      }
    }

    return validRotation ? rotations : -1;
  }

  private static String shift(String stringToShift) {
    int lastCharIndex = stringToShift.length() - 1;
    return stringToShift.charAt(lastCharIndex) + stringToShift.substring(0, lastCharIndex);
  }
}