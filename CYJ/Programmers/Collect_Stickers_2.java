public class Collect_Stickers_2 {
    public int solution(int sticker[]) {
        // 스티커가 1장인 경우
        if(sticker.length == 1) {
            // 해당 스티커 값 return
            return sticker[0];
        }
        // 첫 번째 스티커를 뜯는 경우와, 그렇지 않은 경우를 나눠서 구함
        // 기본적인 dp 식은 같지만, 초기값 설정과 반복문 범위가 다르기 때문임
        // 첫 번째 스티커를 뜯는 경우
        int[] dp1 = new int[sticker.length];
        // 첫 번째 스티커 값이 dp1[0]의 값이 됨
        dp1[0] = sticker[0];
        // System.out.println("dp1[0] = " + sticker[0]);
        // 두 번째 스티커는 이미 찢어진 상태이므로 dp값은 첫 번째 스티커 값이 됨
        dp1[1] = sticker[0];
        // System.out.println("dp1[1] = " + dp1[0]);
        // 첫 번째 스티커를 뜯는 경우로 가정했으므로, 마지막 원소 전까지 반복문 돌림
        for(int i = 2; i < sticker.length - 1; i++) {
            // 더 큰 값으로 저장
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            // System.out.println("dp1[" + i + "] = Math.max(" + dp1[i - 1] + ", " + (dp1[i - 2] + sticker[i]) + ") => " + dp1[i]);
        }
        // 첫 번째 스티커를 뜯지 않는 경우
        int[] dp2 = new int[sticker.length];
        // 두 번째 스티커를 뜯는 경우의 dp값은 자기 자신의 값이 됨
        dp2[1] = sticker[1];
        // System.out.println("dp2[1] = " + sticker[1]);
        // 마지막 원소까지 반복문 돌림
        for(int i = 2; i < sticker.length; i++) {
            // 더 큰 값으로 저장
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
            // System.out.println("dp2[" + i + "] = Math.max(" + dp2[i - 1] + ", " + (dp2[i - 2] + sticker[i]) + ") => " + dp2[i]);
        }
        // 첫 번째 스티커를 뜯었는지 유무에 따른 값을 비교하여 큰 값으로 return
        return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }
}