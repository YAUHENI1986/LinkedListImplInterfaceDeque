# LinkedListImplInterfaceDeque

Создать класс BookLinkedList, который хранит список книг в виде двусвязного списка. Добавить к классу
BookLinkedList реализацию интерфейса Dequee, реализовать все методы кроме перечисленных ниже (во всех
методах, в котрых не требуется реализация сгенерировать собсвенное непроверяемое исключение
BoolListNotSupportedOperation):

 public Iterator iterator();

 public Iterator descendingIterator();

 public Object element();

 public boolean retainAll(Collection c);

 public boolean removeAll(Collection c);

 public boolean addAll(Collection c);

 public boolean containsAll(Collection c);

 public Object[] toArray(Object[] a);

Добавить методы: вставки новой книгу перед конкретной существующей книгой, поиска книги по названию,
сортировки всех книг в списке по году издания. При реализации задания все методы реализовать
самостоятельно, запрещается вызывать готовые реализованные методы из классов пакета java.util.
