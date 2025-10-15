//
//  IconInformation.swift
//  iosApp
//
//  Created by Danilo Osorio on 14/10/25.
//

import SwiftUI

struct IconInformation: View {
    let text:String
    let Icon:Image
    
    var body: some View {
        VStack{
            Icon.resizable()
                .frame(width: 40,height: 50)
            Text(text)
        }
    }
}

#Preview {
    IconInformation(text: "iiiii", Icon: Image("biceps"))
}
