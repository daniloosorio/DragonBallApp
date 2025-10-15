//
//  DetailScreen.swift
//  iosApp
//
//  Created by Danilo Osorio on 14/10/25.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync
import Kingfisher

struct DetailScreen: View {
    let id: Int32
    @StateViewModel
    var detailViewModel: DetailViewModel
    init(id:Int32) {
        self.id = id
        _detailViewModel = StateViewModel(wrappedValue: DetailViewModel(id: id,repository: DiHelper().repository))
    }
    
    var body: some View {
        ZStack{
            VStack{
            LinearGradient(gradient: Gradient(colors:[Color.black,Color.black.opacity(0.5),
                                                      Color.clear]), startPoint: .top, endPoint: .bottom).frame(maxWidth: .infinity).frame(height: 250).ignoresSafeArea(edges:.top)
                Spacer()
            }
            VStack{
                if let detail = detailViewModel.character{
                    Spacer()
                    Text(detail.characterModel.name).font(Font.largeTitle.bold())
                    HStack{
                        LabelInformation(text: detail.characterModel.race)
                        Spacer().frame(width: 40)
                        LabelInformation(text: detail.characterModel.gender)
                    }
                   
                    HStack{
                        Spacer()
                        IconInformation(text: detail.characterModel.ki, Icon: Image("biceps"))
                        Spacer()
                        Divider().frame(width:2,height: 90).overlay(.gray.opacity(0.3))
                        Spacer()
                        IconInformation(text: detail.originPlanet.name, Icon: Image("neptuno"))
                        Spacer()
                    }
                    ScrollView(.horizontal, showsIndicators: false){
                        LazyHStack{
                            ForEach(detail.transformations, id: \.self){ item in
                                TransformationView(transformation: item)
                            }
                        }.frame(height: 250)
                    }
                    Spacer().frame(height: 20)
                }
            }.frame(maxWidth: .infinity,maxHeight: .infinity).background(.white).padding(.horizontal,16).cornerRadius(20).shadow(radius: 10).padding(.top,120).padding(.bottom,32)
            
            VStack{
                if let detail = detailViewModel.character{
                    KFImage(URL(string: detail.characterModel.image))
                        .placeholder{ProgressView()}
                        .resizable()
                        .scaledToFit()
                        .frame(height: 200)
                }
                Spacer()
            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity).background(Color.backgroundPrimary)
    }
}

#Preview {
    DetailScreen(id:2)
}
