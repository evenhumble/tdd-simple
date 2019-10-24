//
//  DetailViewController.h
//  QToDo
//
//  Created by patrick on 2019/10/24.
//  Copyright © 2019年 qkits. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController

@property (strong, nonatomic) NSDate *detailItem;
@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;

@end

