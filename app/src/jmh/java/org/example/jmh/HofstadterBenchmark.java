package org.example.jmh;

import org.example.Hofstadter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)               
@Fork(value = 1, warmups = 0)     
@Warmup(iterations = 0)             
@Measurement(iterations = 5, time = 20, timeUnit = TimeUnit.MILLISECONDS)
public class HofstadterBenchmark {

    private Hofstadter hofstadter;

    @Param({"5", "10", "15", "20"})
    public int n;

    @Setup(Level.Iteration)
    public void setUp() {
        hofstadter = new Hofstadter();
    }

    @Benchmark
    @Timeout(time = 3, timeUnit = TimeUnit.SECONDS)
    public void naive(Blackhole bh) {
        bh.consume(hofstadter.gSequence(n));
    }

    @Benchmark
    @Timeout(time = 3, timeUnit = TimeUnit.SECONDS)
    public void memoized(Blackhole bh) {
        bh.consume(hofstadter.gSequenceMemo(n));
    }
}
