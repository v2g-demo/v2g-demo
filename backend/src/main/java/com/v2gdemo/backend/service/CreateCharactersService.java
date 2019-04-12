package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.Character;

public interface CreateCharactersService {
  Character createCharacters(Long userId, long mapId);
}
