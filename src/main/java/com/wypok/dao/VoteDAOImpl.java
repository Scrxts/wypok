package com.wypok.dao;

import com.wypok.models.Vote;
import com.wypok.util.ConnectionProvider;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteDAOImpl implements VoteDAO {

    private static final String CREATE_VOTE = "INSERT INTO vote(discovery_id, user_id, date, type) "
            + "VALUES (:discovery_id, :user_id, :date, :type);";
    private static final String READ_VOTE = "SELECT vote_id, discovery_id, user_id, date, type "
            + "FROM vote WHERE vote_id = :vote_id;";
    private static final String READ_VOTE_BY_DISCOVERY_USE_IDS = "SELECT vote_id, discovery_id, user_id, date, type "
            + "FROM vote WHERE user_id = :user_id AND discovery_id = :discovery_id;";
    private static final String UPDATE_VOTE = "UPDATE vote SET date=:date, type=:type WHERE vote_id=:vote_id;";

    private NamedParameterJdbcTemplate template;

    public VoteDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Vote create(Vote vote) {
        Vote voteCopy = new Vote(vote);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("discovery_id", voteCopy.getDiscoveryId());
        paramMap.put("user_id", voteCopy.getUserId());
        paramMap.put("date", voteCopy.getDate());
        paramMap.put("type", voteCopy.getVoteType().toString());
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_VOTE, paramSource, holder);
        if(update > 0) {
            voteCopy.setId(holder.getKey().longValue());
        }
        return voteCopy;
    }

    @Override
    public Vote read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Vote updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Vote> getAll() {
        return null;
    }

    @Override
    public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId) {
        return null;
    }
}
