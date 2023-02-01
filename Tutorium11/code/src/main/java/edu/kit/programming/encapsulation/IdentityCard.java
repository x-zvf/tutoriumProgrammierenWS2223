package edu.kit.programming.encapsulation;/*
 * Theoretisch Copy Constructor unnötig, da Objekt immutable (unveränderbar) ist.
 * Vermerke im Klassen JavaDoc falls Instanzen immutable sind.
 */

public class IdentityCard {
  private final int idNumber;

  /*
   * Konstruktor zum erstellen eines IdentityCard Objektes.
   */
  public IdentityCard(int idNumber) {
    this.idNumber = idNumber;
  }

  /*
   * Copy Constructor. Übergibt eine exakte Kopie alle Attribute, aber neue Objekt Referenz (this == identityCard ergibt false).
   */
  public IdentityCard(IdentityCard identityCard) {
    this.idNumber = identityCard.idNumber;
  }

  public int getId() {
    return idNumber;
  }
}
