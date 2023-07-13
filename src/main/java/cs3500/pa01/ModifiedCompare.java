package cs3500.pa01;

/**
 * Represents a sort based on FileTime modified.
 */
public class ModifiedCompare extends AbsCompare {

  /**
   * Overrides the compare function to compare Markdown objects based on this class.
   *
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   * @return the integer result of compare according to modified date.
   */
  @Override
  public int compare(MarkdownFile o1, MarkdownFile o2) {
    return o1.modified.compareTo(o2.modified);
  }
}
