package org.tamama.temporary.reenterant_lock;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.tamama.config.RedissonProvider;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Service
public class ReenterantLock {
    private final RedissonProvider redisProvider;

    public void reenterantLockMethod() throws InterruptedException {
        RLock lock = redisProvider.createClient().getLock("lockName");
        // traditional lock method
        lock.lock();

        // or acquire lock and automatically unlock it after 10 seconds
        lock.lock(10, TimeUnit.SECONDS);

        // or wait for lock acquisition up to 100 seconds and auto-unlock after 10 seconds
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
        if (res) {
            try {
                // ...
            } finally {
                lock.unlock();
            }
        }
    }
}
