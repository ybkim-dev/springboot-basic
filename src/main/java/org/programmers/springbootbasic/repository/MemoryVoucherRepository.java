package org.programmers.springbootbasic.repository;

import org.programmers.springbootbasic.domain.Voucher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryVoucherRepository implements VoucherRepository{

    private final Map<UUID, Voucher> store = new ConcurrentHashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(MemoryVoucherRepository.class);

    @Override
    public Voucher save(Voucher voucher) {
        logger.info("voucher 저장");
        store.put(voucher.getVoucherId(), voucher);
        return voucher;
    }

    @Override
    public List<Voucher> findAll() {
        logger.info("Voucher 전체 조회");
        return new ArrayList<>(store.values());
    }
}
