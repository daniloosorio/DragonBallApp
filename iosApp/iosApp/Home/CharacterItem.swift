//
//  CharacterItem.swift
//  iosApp
//
//  Created by Danilo Osorio on 2/10/25.
//

import SwiftUI
import Shared

struct CharacterItem: View {
    let item:CharacterModel
    var body: some View {
        Text(item.name)
    }
}

#Preview {
    CharacterItem(item: CharacterModel(id: 2, name: "holi", ki: "0", race: "asd", gender: "female", description: "sfd", image: "dfd"))
}
