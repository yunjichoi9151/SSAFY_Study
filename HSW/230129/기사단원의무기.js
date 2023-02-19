function solution(number, limit, power) {
  let answer = 0;

  for (let i = 1; i <= number; i++) {
    let count = 0;
    for (let j = 1; j <= Math.sqrt(i); j++) {
      if (j * j === i) count += 1;
      else if (i % j === 0) count += 2;
    }
    //약수의 개수가 제한수치를 넘으면 정해진 power만큼만
    //아니면 약수의 개수를 철의 무게 answer에 추가
    answer += count > limit ? power : count;
  }

  return answer;
}
