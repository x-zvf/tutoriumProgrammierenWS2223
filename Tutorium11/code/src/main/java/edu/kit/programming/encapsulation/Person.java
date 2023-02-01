public class Person {
  private String name;
  private int age;
  private IdentityCard id;

  /*
   * Alternative 1:
   * Konstruktor nimmt nur elementare Datentypen an und erstellt Objektinstanzen selbst.
   * Nachteile:
   * - schnell unübersichtlich
   * - falls Konstruktor des zu erstellenden Objektes geändert wird (hier IdentityCard),
   * muss dieser Konstruktor mit geändert werden.
   */
  public Person(String name, int age, int idNumber) {
    this.name = name;
    this.age = age;
    this.id = new IdentityCard(idNumber);
  }

  /*
   * Alternative 2:
   * Konstruktor nimmt Objektinstanz direkt an. Objekteninstanzen müssen eventuell kopiert werden.
   */
  public Person(String name, int age, IdentityCard id) {
    this.name = name;
    this.age =  age;
    this.id = new IdentityCard(id);
  }

  /*
   * Copy Constructor, erstellt eine deep copy (auch nicht elementare Attribute werden kopiert.)
   */
  public Person(Person person) {
    this(person.name, person.age, person.id);
  }
}

