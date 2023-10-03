package find


def findAllAndPrint(entry: cs214.Entry): Boolean =
  println(entry.path())

  if entry.isDirectory() && entry.hasChildren() then
    findAllAndPrint(entry.firstChild())
  if entry.hasNextSibling() then
    findAllAndPrint(entry.nextSibling())

  true

def findByNameAndPrint(entry: cs214.Entry, name: String): Boolean =
  val thisFound =
    entry.name() == name
      && { println(entry.path()); true }

  val childrenFound =
    entry.isDirectory()
      && entry.hasChildren()
      && findByNameAndPrint(entry.firstChild(), name)

  val nextSiblingsFound =
    entry.hasNextSibling()
      && findByNameAndPrint(entry.nextSibling(), name)

  thisFound || childrenFound || nextSiblingsFound

def findBySizeEqAndPrint(entry: cs214.Entry, size: Long): Boolean =
  val thisFound =
    !entry.isDirectory()
      && entry.size() == size
      && { println(entry.path()); true }

  val childrenFound =
    entry.isDirectory()
      && entry.hasChildren()
      && findBySizeEqAndPrint(entry.firstChild(), size)

  val nextSiblingsFound =
    entry.hasNextSibling()
      && findBySizeEqAndPrint(entry.nextSibling(), size)

  thisFound || childrenFound || nextSiblingsFound

def findBySizeGeAndPrint(entry: cs214.Entry, minSize: Long): Boolean =
  val thisFound =
    !entry.isDirectory()
      && entry.size() >= minSize
      && { println(entry.path()); true }

  val childrenFound =
    entry.isDirectory()
      && entry.hasChildren()
      && findBySizeGeAndPrint(entry.firstChild(), minSize)

  val nextSiblingsFound =
    entry.hasNextSibling()
      && findBySizeGeAndPrint(entry.nextSibling(), minSize)

  thisFound || childrenFound || nextSiblingsFound

def findEmptyAndPrint(entry: cs214.Entry): Boolean =
  val isEmpty =
    if entry.isDirectory() then
      !entry.hasChildren()
    else
      entry.size() == 0

  val thisFound =
    isEmpty && { println(entry.path()); true }

  val childrenFound =
    entry.isDirectory()
      && entry.hasChildren()
      && findEmptyAndPrint(entry.firstChild())

  val nextSiblingsFound =
    entry.hasNextSibling()
      && findEmptyAndPrint(entry.nextSibling())

  thisFound || childrenFound || nextSiblingsFound

def howManyHoursISpentOnThisLab(): Double =
  0.0 // in hours, so put 3.5 here if you spent 3 hours and a half on the lab

def findFirstByNameAndPrint(entry: cs214.Entry, name: String): Boolean =
  val thisFound =
    entry.name() == name
      && { println(entry.path()); true }

  def childrenFound =
    entry.isDirectory()
      && entry.hasChildren()
      && findFirstByNameAndPrint(entry.firstChild(), name)

  def nextSiblingsFound =
    entry.hasNextSibling()
      && findFirstByNameAndPrint(entry.nextSibling(), name)

  thisFound || childrenFound || nextSiblingsFound
