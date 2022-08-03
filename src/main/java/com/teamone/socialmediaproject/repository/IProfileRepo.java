package com.teamone.socialmediaproject.repository;

import com.teamone.socialmediaproject.model.Profile;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

public interface IProfileRepo extends CrudRepository<Profile,Long> {
}
