package com.wypok.dao;

import com.wypok.models.Vote;

public interface VoteDAO extends GenericDAO<Vote,Long> {
    public Vote getVoteByUserIdDiscoveryId(long userid, long discoveryid);

}
