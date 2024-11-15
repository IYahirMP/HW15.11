package com.solvd.laba.carina.demo.db.mappers;

import com.solvd.laba.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
