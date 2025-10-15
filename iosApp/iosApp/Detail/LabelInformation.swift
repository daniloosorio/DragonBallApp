//
//  LabelInformation.swift
//  iosApp
//
//  Created by Danilo Osorio on 14/10/25.
//

import SwiftUI

struct LabelInformation: View {
    let text: String
    
    var body: some View {
        Text(text).padding(.horizontal,20).padding(.vertical,8)
            .overlay(RoundedRectangle(cornerRadius: 20).stroke(Color(.backgroundPrimary),lineWidth: 3))
    }
}

#Preview {
    LabelInformation(text: "2")
}
