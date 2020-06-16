package com.wypok.service;

import com.wypok.dao.DAOFactory;
import com.wypok.dao.VoteDAO;
import com.wypok.models.Vote;
import com.wypok.models.VoteType;

import java.sql.Timestamp;
import java.util.Date;


public class VoteService {
    public Vote addVote(long discoveryId, long userId, VoteType voteType){
        Vote vote = new Vote();
        vote.setDiscoveryId(discoveryId);
        vote.setUserId(userId);
        vote.setDate(new Timestamp(new Date().getTime()));
        vote.setVoteType(voteType);
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        VoteDAO voteDao = daoFactory.getVoteDAO();
        vote = voteDao.create(vote);
        return vote;
    }

    public Vote updateVote(long discoveryId, long userId, VoteType voteType){
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote voteToUpdate = voteDAO.getVoteByUserIdDiscoveryId(userId,discoveryId);
        if (voteToUpdate != null){
            voteToUpdate.setVoteType(voteType);
            voteDAO.update(voteToUpdate);
        }
        return voteToUpdate;
    }

    public Vote addOrUpdateVote(long discoveryId, long userId, VoteType voteType){
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote vote = voteDAO.getVoteByUserIdDiscoveryId(userId,discoveryId);
        Vote resultVote = null;
        if (vote == null){
            resultVote = addVote(discoveryId,userId,voteType);
        } else {
            resultVote = updateVote(discoveryId, userId, voteType);
        }
        return resultVote;
    }

    public Vote getVoteByDiscoveryUserId(long discoveryId, long userId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote vote = voteDAO.getVoteByUserIdDiscoveryId(userId,discoveryId);
        return vote;
    }
}
