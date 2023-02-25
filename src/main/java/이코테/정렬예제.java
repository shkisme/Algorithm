package 이코테;

public class 정렬예제 {

  public static void main(String[] args) {
    // 선택 정렬
    // 2중 반복문 때문에 데이터의 개수가 커지면 효율이 좋지않다.
    int n = 10;
    int[] arr = {7, 6, 9, 0, 3, 1, 6, 2, 4, 8};

    for (int i = 0; i < n; ++i) {
      int min_index = i;
      for (int j = i + 1; j < n; ++j) {
        if (arr[min_index] > arr[j]) {
          min_index = j;
        }
      }
      // 바꾸기
      int temp = arr[i];
      arr[i] = arr[min_index];
      arr[min_index] = temp;
    }

    // 삽입 정렬
    // 선택 정렬과 흡사한 시간이 소요됨.
    // 하지만 거의 정렬되어 있는 상태로 입력이 주어진다면 삽입 정렬이 정답 확률을 높일 수 있다.
    for (int i = 1; i < n; ++i) { // 첫번째 데이터는 그 자체로 정렬되어 있다고 생각하자.
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        } else { // 자기보다 큰 데이터 만나면 멈춘다.
          break;
        }
      }
    }

    // 퀵 정렬
    quickSort(arr, 0, n - 1);
  }

  private static void quickSort(int[] arr, int start, int end) {
    if (start >= end) {
      return; // 원소가 1개일 경우 종료
    }
    int pivot = start;
  }

}
