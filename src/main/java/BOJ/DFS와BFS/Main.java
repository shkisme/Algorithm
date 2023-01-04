package BOJ.DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

  static int numberOfNodes, numberOfEdges;
  static String startNode;

  static HashMap<String, ArrayList<String>> map1 = new HashMap<>();

  static HashMap<String, String> map2 = new HashMap<>();

  static List<String> dfs_answer = new ArrayList<>();

  static Stack<String> stack = new Stack<>();

  static Queue<String> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    input(br);
    solveDFS();
    print(bw);

    bw.flush();
    br.close();
    bw.close();
  }

  private static void input(BufferedReader br) throws IOException {
    String[] s = br.readLine().split(" ");
    numberOfNodes = Integer.parseInt(s[0]);
    numberOfEdges = Integer.parseInt(s[1]);
    startNode = s[2];
    for(int i = 0; i < numberOfEdges; i++){
      String[] numbers = br.readLine().split("");
      String key = numbers[0];
      String value = numbers[1];
      if (map1.containsKey(key)){
        map1.get(key).add(value);
      }
      else{
        ArrayList<String> strings = new ArrayList<>();
        strings.add(value);
        map1.put(key, strings);
      }
    }
  }

  private static void solveDFS() {
    String node = startNode;
    stack.push(node);
    dfs_answer.add(node);
    while(!stack.empty()){
      if (map1.containsKey(node)){
        String value = map1.get(node).get(0);
        stack.push(value);
        dfs_answer.add(value);
        System.out.println("value = " + value);
        map1.get(node).remove(0);
        if (map1.get(node).isEmpty()){
          map1.remove(node);
        }
        node = value;
      }
      else{
        node = stack.peek();
        stack.pop();
      }
    }
  }

  private static void print(BufferedWriter bw) {
    for (String s : dfs_answer) {
      System.out.print(s + " ");
    }
  }
}
