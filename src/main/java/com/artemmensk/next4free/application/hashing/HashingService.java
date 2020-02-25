package com.artemmensk.next4free.application.hashing;

import com.artemmensk.next4free.domain.HashedPassword;
import com.artemmensk.next4free.domain.Password;

public interface HashingService {
    HashedPassword hash(Password password);
}
