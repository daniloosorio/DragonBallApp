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
    var homeViewModel = HomeViewModel(repository: DiHelper().repository)
    
    var body: some View {
        if  !homeViewModel.charactersValue.isEmpty{
            NavigationStack{
                VStack{
                    Text("Vegeta Edition").font(.title).bold().foregroundColor(Color(.backgroundTertiary))
                    ScrollView{
                        LazyVStack{
                            ForEach(homeViewModel.charactersValue, id:\.self){ character in
                                NavigationLink(destination: {}, label: {
                                    CharacterItem(item: character)
                                })
                                
                            }
                        }
                    }
                }.background(Color(.backgroundPrimary))
            }
        }else {
            ProgressView()
        }
    }
}

#Preview {
    HomeScreen()
}
