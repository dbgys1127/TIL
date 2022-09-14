package com.codestates.helper;

import java.net.URI;

public interface MemberControllerTestHelper extends ControllerTestHelper {
    String MEMBER_URL = "/v11/members";
    default URI getURI() {
        return createURI(MEMBER_URL);
    }

    default URI getURI(long memberId) {
        return createURI(MEMBER_URL + "/{memberId}", memberId);
    }
}
