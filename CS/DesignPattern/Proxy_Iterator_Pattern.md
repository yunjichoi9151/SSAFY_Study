# Proxy Pattern

**Structural Design Pattern**

> 어떤 다른 객체로 접근하는 것을 통제하기 위해 그 객체의 매니저를 제공하는 패턴
> 

프록시는 대리자, 대변인이라는 뜻을 가지고 있다.

![Problem_Proxy](./img/ProxyPattern1.png)

![Solution_Proxy](./img/ProxyPattern2.png)

## 프록시 패턴의 구조

![출처 : [https://refactoring.guru/design-patterns/proxy](https://refactoring.guru/design-patterns/proxy)](./img/ProxyPattern3.png)

출처 : [https://refactoring.guru/design-patterns/proxy](https://refactoring.guru/design-patterns/proxy)

### **Service Interface**

- 서비스의 인터페이스를 선언
- 프록시 객체는 서비스 객체와 마찬가지로 이 인터페이스를 따라야함

### **Service**

- 실제 서비스를 제공하는 객체

### **Proxy**

- 실제 서비스 객체를 참조하는 필드가 있어야함
- 서비스 객체로 향하는 요청을 가로채서 먼저 처리
- 프록시가 처리를 마친 후 필요 시 서비스 객체에 요청을 전달
- 일반적으로 프록시가 서비스 객체의 전체 수명주기를 관리

## 대표적인 프록시의 사용 예시

### 초기화 지연(가상 프록시)

- 시스템 리소스를 크게 잡아먹는 서비스 객체
- 시스템 가동시에 객체를 초기화하는 것이 아닌, 필요할 때만 프록시 객체에서 요청을 보내서 서비스 객체를 초기화할 수 있도록 지연

### 접근 제어(보호 프록시)

- 특정 클라이언트만 서비스 객체에 접근할 수 있도록 하려는 경우
- 서비스 객체가 시스템(운영 체제)의 중요한 부분일 경우
- 프록시는 클라이언트의 자격 증명이 기준과 일치할 경우에만 서비스 객체에 요청을 전달

### 원격 서비스의 로컬 실행(원격 프록시)

- 서비스 객체가 원격 서버에 있는 경우
- 프록시는 네트워크를 통해 클라이언트 요청을 전달
- 네트워크 작업의 세부 사항을 프록시가 처리

그 외에도..

### 로깅 요청(로깅 프록시)

- 서비스를 전달하기 전에 요청을 프록시가 기록

### 캐싱 요청(캐싱 프록시)

- 클라이언트 요청의 결과를 캐시하고 이 캐시의 수명 주기를 관리
- 동일한 결과를 생성하는 반복 요청이 있을 때 사용

## 프록시 패턴의 장점

- 사이즈가 큰 객체가 로딩이 되기 전에 프록시를 통해 미리 참조할 수 있다
- 실제 객체의 메소드를 숨기고 인터페이스를 통한 노출이 가능
- 로컬에 있지 않은 객체도 사용할 수 있다
- 원래 객체에의 접근에 대해 사전처리가 가능(초기화 지연, 접근 제어, 로깅, 캐싱 등)

## 프록시 패턴의 단점

- 객체를 생성하기 전에 프록시 객체를 거쳐야하므로, 객체 생성이 잦을 경우 성능저하
- 프록시 내부에서 객체 생성을 위해 스레드 생성, 동기화가 구현되어야 하는 경우 성능이 저하될 수 있다. (멀티 스레드)
- 로직이 난해해져 가독성이 떨어질 수 있다

### 예시

- Spring의 AOP
- 웹서버와 프록시서버

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
