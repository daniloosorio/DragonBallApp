//
//  CharacterItem.swift
//  iosApp
//
//  Created by Danilo Osorio on 2/10/25.
//

import SwiftUI
import Shared
import Kingfisher

struct CharacterItem: View {
    let item:CharacterModel
    var body: some View {
        ZStack{
            DiamondShape()
                .fill(Color(.backgroundSecondary))
                .frame(width: 300,height: 300)
                .overlay(DiamondShape().stroke(
                    Color(.backgroundTertiary),lineWidth: 9))
                .rotationEffect(Angle(degrees: 180))

            
            VStack{
                Spacer()
                VStack{
                    Text(item.name).font(.headline)
                    Text(item.race).font(.subheadline)
                    
                }.frame(maxWidth: .infinity)
                    .padding(8)
                    .background(RoundedRectangle(cornerRadius: 10)
                        .stroke(Color(.backgroundTertiary),lineWidth: 9)
                        .background(Color(.backgroundSecondary)))
                    .offset(y:10)
            }
            KFImage(URL(string: item.image))
                .placeholder{
                    ProgressView()
                }.resizable()
                .scaledToFit()
                .frame(maxWidth: 100,maxHeight: 250)
        }.padding(.horizontal,24).padding(.vertical,12)
    }
}

#Preview {
    CharacterItem(item: CharacterModel(id: 2, name: "holi", ki: "0", race: "asd", gender: "female", description: "sfd", image: "dfd"))
}
