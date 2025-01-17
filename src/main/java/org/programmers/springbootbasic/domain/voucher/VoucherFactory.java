package org.programmers.springbootbasic.domain.voucher;

import org.programmers.springbootbasic.data.VoucherType;
import org.programmers.springbootbasic.domain.voucher.model.FixedAmountVoucher;
import org.programmers.springbootbasic.domain.voucher.model.PercentDiscountVoucher;
import org.programmers.springbootbasic.domain.voucher.model.Voucher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Voucher가 추가될 경우 case 문에 추가해서 처리 가능.
 */
@Component
public class VoucherFactory {
    private static final Logger logger = LoggerFactory.getLogger(VoucherFactory.class);

    public Voucher getVoucher(VoucherType type, long amount) {
        return switch (type) {
            case FIXED -> {
                logger.info("FixedAmountVoucher 생성");
                yield new FixedAmountVoucher(UUID.randomUUID(), amount);
            }
            case PERCENT -> {
                logger.info("PercentDiscountVoucher 생성");
                yield new PercentDiscountVoucher(UUID.randomUUID(), amount);
            }
        };
    }
}
