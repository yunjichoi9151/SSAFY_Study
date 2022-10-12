# Iterator Pattern

**Behavioral Design Pattern**

> 내부 표현부를 노출하지 않고 어떤 객체 집합의 원소들을 순차적으로 접근할 수 있는 방법을 제공하는 패턴
> 
반복자(Iterator)를 사용하여 컬렉션 요소에 접근하는 디자인 패턴

반복자(Iterator)란? 컬렉션(주로 리스트) 요소들을 순회, 접근하게 해주는 객체

이터레이터 패턴을 활용해서 컬렉션에 접근하게 되면 

컬렉션의 내부를 노출시키지 않고도 그 요소에 접근할 수 있게 된다

내부 구조를 잘 몰라도, 구현이 어떻게 되어 있어도 반복자(Iterator)를 사용하여 내부 요소를 순회하는 것이 가능해지기 때문에 이 패턴을 사용한다.

또한 접근방식을 통일시킴으로써 어떤 종류의 객체에도 대응할 수 있는 다형적인 코드를 만들 수 있다.

## 이터레이터 패턴의 구조

![출처 : [https://refactoring.guru/design-patterns/iterator](https://refactoring.guru/design-patterns/iterator)](./img/IteratorPattern.png)

출처 : [https://refactoring.guru/design-patterns/iterator](https://refactoring.guru/design-patterns/iterator)

### Iterator Interface

- 컬렉션 순회에 필요한 작업(getNext(), hasMore() 메소드 등)을 선언

### Concrete Iterator

- Iterator Interface를 실제로 구현
- 컬렉션 순회를 위한 특정 알고리즘 구현

### IterableCollection Interface

- 컬렉션과 호환되는 Iterator를 얻기 위한 메소드 선언

### ConcreteCollection

- 위의 인터페이스를 실제로 구현

## 이터레이터 패턴의 장점

- 부피가 큰 순회 알고리즘을 별도의 클래스로 추출하여 코드를 정리할 수 있다
- 기존 코드를 건드리지 않고 새로운 유형의 컬렉션 및 반복자를 구현할 수 있다
- 동일한 컬렉션을 병렬로 반복할 수 있다

## 이터레이터 패턴의 단점

- 간단한 프로그램의 경우 패턴을 적용하면 과도할 수 있다
- 일부 특수 컬렉션의 요소를 직접 탐색하는 것보다 덜 효율적일 수 있다

### 참고용 코드

### Book.java (Class)

```java
package IteratorPattern;
public class Book {
		private String title;
		public Book(String title) {
				this.title = title;
		}
		public String getTitle() {
				return title;
		}
}
```

### BookShelf.java (Manager = ConcreteCollection 역할)

```java
package IteratorPattern;
public class BookShelf implements IterableCollection {
		private Book[] books;
		private int lastIdx = 0;
		public BookShelf(int maxSize) {
				this.books = new Book[maxSize];
		}
		public Book getBookAt(int index) {
				return books[index];		
		}
		public void appendBook(Book book) {
				this.books[lastIdx++] = book;
		}
		public int getLength() {
				return lastIdx;
		}
		public Iterator iterator() {
				return new BookShelfIterator(this);
		}
}
```

### BookShelfIterater.java (Concrete Iterator)

```java
package IteratorPattern;
public class BookShelfIterator implements Iterator {
		private BookShelf bookShelf;
		private int index;
		public BookShelfIterator(BookShelf bookShelf) {
				this.bookShelf = bookShelf;
				this.index = 0;
		}
		public boolean hasNext() {
				if(index < bookShelf.getLength()) {
						return true;
				}
				return false;
		}
		public Object next() {
				Book book = bookShelf.getBookAt(index++);
				return book;
		}
}
```

### Iterator.java (Iterator Interface) → BookShelfIterater.java 로 연결

```java
package IteratorPattern;
public interface Iterator {
		public abstract boolean hasNext();
		public abstract Object Next();
}
```

### IterableCollection.java (IterableCollection) → BookShelf.java 로 연결

```java
package IteratorPattern;
public interface IterableCollection {
		public abstract Iterator iterator();
}
```

참고출처 : [https://yssa.tistory.com/entry/Design-Pattern-반복자-패턴Iterator-Pattern](https://yssa.tistory.com/entry/Design-Pattern-%EB%B0%98%EB%B3%B5%EC%9E%90-%ED%8C%A8%ED%84%B4Iterator-Pattern)