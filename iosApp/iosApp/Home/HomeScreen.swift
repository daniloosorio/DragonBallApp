//
//  HomeScreen.swift
//  iosApp
//
//  Created by Danilo Osorio on 18/09/25.
//

import SwiftUI
import Shared
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI

struct HomeScreen: View {
    
    @StateViewModel
    var homeViewModel = HomeViewModel()
    
    var body: some View {
        Text(homeViewModel.exampleValue)
    }
}

#Preview {
    HomeScreen()
}
