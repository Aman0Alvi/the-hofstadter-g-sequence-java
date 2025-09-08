package org.example;

import java.util.HashMap;
import java.util.Map;

public class Hofstadter {
  // Your implementations of the sequence goes here.
  // Recall that you can calculate the nth term, G(n), using:
  // G(n) = n - G(G(n-1))
  // G(0) = 0

  // ---------- Naive recursive version ----------
  public Integer gSequence(Integer index) {
    if (index == 0) return 0;
    return index - gSequence(gSequence(index - 1));
  }

  // ---------- Memoized recursive version ----------
  private final Map<Integer, Integer> memo = new HashMap<>();

  public Hofstadter() {
    memo.put(0, 0);
  }

  public Integer gSequenceMemo(Integer index) {
    if (memo.containsKey(index)) {
      return memo.get(index);
    }
    int result = index - gSequenceMemo(gSequenceMemo(index - 1));
    memo.put(index, result);
    return result;
  }

  public void clearMemo() {
    memo.clear();
    memo.put(0, 0);
  }
}
