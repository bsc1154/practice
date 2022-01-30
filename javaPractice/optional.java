package chapter14;
import java.util.*;
import java.util.stream.*;

class optional {
	public static void main(String[] args) {
		//반드시 있어야 하는 경우 반드시 값이 있어야 하는 객체인 경우 해당 메서드를 사용하면 됩니다.
		String a = "ddd";
		Optional<String> opt = Optional.of(a);
		System.out.println(a);


		//value가 null 인 경우 비어있는 Optional 을 반환합니다.
		//값이 null 일수도 있는 것은 해당 메서드를 사용하면 됩니다.
		//public static <T> Optional<T> ofNullable(T value);
		Optional<String> opt2 = Optional.ofNullable("dddddd");
		System.out.println(opt2);

		// 메서드 시그니처
		// 예제
		Optional<String> emptyOpt = Optional.empty();
		System.out.println(emptyOpt);

		// 메서드 시그니처

		//Optional.of("True").filter((val) -> "True".eqauls(val)).orElse("NO DATA"); // "True"
		//Optional.of("False").filter((val) -> "True".eqauls(val)).orElse("NO DATA"); // "NO DATA"


		//mapper 함수를 통해 입력값을 다른 값으로 변환하는 메서드
		String result = Optional.of("result")
				.flatMap((val) -> Optional.of("good"))
				.get();
		System.out.println(result); // print 'good'

		Optional.of("test").ifPresent((value) -> {
			// something to do
			System.out.println("**");
		});
		// 예제2 (ifPresent 미수행)
		Optional.ofNullable(null).ifPresent((value) -> {
			// nothing to do

			System.out.println("**2");
		});


		//Optional.ofNullable("test").isPresent(); // true
		//Optional.ofNullable("test").filter((val) -> "result".eqauls(val)).isPresent(); // false

		// 메서드 시그니처
		public T orElse(T other);
		// 예제
		String result = Optional.ofNullable(null).orElse("default");
		System.out.println(result); // print 'default'

		// 메서드 시그니처
		public T orElseGet(Supplier<? extends T> other);
		// 예제
		String result = Optional.ofNullable("input").filter("test"::equals).orElseGet(() -> "default");
		System.out.println(result); // print 'default'

		Optional.ofNullable("input").filter("test"::equals).orElseThrow(NoSuchElementException::new);


		Optional.ofNullable(something).orElseGet(() -> {
			// business logic ...
			return value;
		});

	}
}
