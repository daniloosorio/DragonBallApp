//
//  TransformationView.swift
//  iosApp
//
//  Created by Danilo Osorio on 14/10/25.
//

import SwiftUI
import Shared
import Kingfisher

struct TransformationView: View {
    let transformation: TransformationModel
    var body: some View {
        VStack{
            KFImage(URL(string: transformation.image))
                .placeholder{
                    ProgressView()
                }.resizable()
                .scaledToFit()
                //.frame(maxWidth: 100,maxHeight: 150)
            Text(transformation.name)
        }.padding(.horizontal,24).padding(.vertical,12).cornerRadius(20)
            .shadow(radius: 16)
            .overlay(RoundedRectangle(cornerRadius: 20).stroke(.gray))
        
    }
}

#Preview {
    TransformationView(transformation: TransformationModel(name:"pepe",image: "https://i.pinimg.com/736x/94/34/a9/9434a993e5fa716f39878b1ef808f3f1.jpg",ki: "2323"))
}
