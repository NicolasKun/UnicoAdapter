
### UnicoAdapter

---

[ ![Download](https://api.bintray.com/packages/unicolas/maven/nicoadapter/images/download.svg) ](https://bintray.com/unicolas/maven/nicoadapter/_latestVersion)
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)

在app下的build.gradle中引入

> compile 'im.unicolas:nicoadapter:0.7.0'

#### 使用方法如下

- GeneralAdapter

```
        generalAdapter = new GeneralAdapter<TestBean>(context,
                list, R.layout.item_test_layout) {
            @Override
            public void convert(ViewsHolder holder, TestBean item, int position) {
                String s = item.getZan() + " like";
                holder.setText(R.id.item_tl_likes, s);
                holder.setText(R.id.item_tl_signture, item.getSignture());
                holder.setText(R.id.item_tl_name, item.getName());
            }
        };
        listView.setAdapter(generalAdapter);
```

- UnicoRecyAdapter

```
        unicoRecyAdapter = new UnicoRecyAdapter<TestBean>(context, list, R.layout.item_test_layout) {
            @Override
            public void convert(UnicoViewsHolder holder, TestBean item, int position) {
                String s = item.getZan() + "次赞";
                holder.setTvTxt(R.id.item_tl_likes, s);
                holder.setTvTxt(R.id.item_tl_signture, item.getSignture());
                holder.setTvTxt(R.id.item_tl_name, item.getName());
            }

            /**
             * //FIXME 此方法按需重写
             * @param view     itemView
             * @param item     条目内容
             * @param position   点击条目的position
             */
            @Override
            public void itemClickObtain(View view, TestBean item, int position) {
                super.itemClickObtain(view, item, position);
                Toast.makeText(context, item.getSignture(), Toast.LENGTH_SHORT).show();
            }
        };

        recyclerView.setAdapter(unicoRecyAdapter);
```

> 以上TestBean为示例实体类


## END
