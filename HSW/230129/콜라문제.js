function solution(a, b, n) {
  let answer = 0;

  //a개의 병을 주면 b개를 환급
  //전체 병은 n개

  //JS는 정수형 실수형이 따로 없기 때문에 Math.floor 처리를 안해주면 결과가 소수로 나온다
  while (n >= a) {
    answer += Math.floor(n / a) * b;
    let m = (n % a) + Math.floor(n / a) * b;
    n = m;
  }
  return answer;
}
