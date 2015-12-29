package com.smallwei.day2demo;

import java.util.List;

/**
 * Created by smallwei on 2015/12/29.
 */
public class Response {

    /**
     * format : word
     * image : null
     * published_at : 1451346901
     * tag :
     * user : {"avatar_updated_at":1451392978,"last_visited_at":1327836426,"created_at":1327836426,"state":"active","email":" ","last_device":"ios_1.0","role":"n","login":"潇湘墨兰","id":441420,"icon":"20151229124258.jpg"}
     * image_size : null
     * id : 114462277
     * votes : {"down":-364,"up":15294}
     * created_at : 1451344564
     * content : 见学长夫妇，说是最近俩人一直分床睡，已经好几个月了。我还以为是关系冷淡期，关切地问怎么回事。学长含羞一笑，说俩人共同爱好太多，三观太和，永远有聊不完的话题，一不小心就唠到三四点，再愉快地啪啪一下，第二天根本没法起床上班...秀得我泪流满面…
     * state : publish
     * comments_count : 132
     * allow_comment : true
     * share_count : 510
     * type : hot
     */

    private List<ItemsEntity> items;

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        private String format;
        private Object image;
        /**
         * avatar_updated_at : 1451392978
         * last_visited_at : 1327836426
         * created_at : 1327836426
         * state : active
         * email :
         * last_device : ios_1.0
         * role : n
         * login : 潇湘墨兰
         * id : 441420
         * icon : 20151229124258.jpg
         */

        private UserEntity user;
        private int id;
        /**
         * down : -364
         * up : 15294
         */

        private VotesEntity votes;
        private String content;

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFormat() {
            return format;
        }

        public Object getImage() {
            return image;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public String getContent() {
            return content;
        }

        public static class UserEntity {
            private String login;
            private int id;
            private String icon;

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }

        public static class VotesEntity {
            private int down;
            private int up;

            public void setDown(int down) {
                this.down = down;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public int getDown() {
                return down;
            }

            public int getUp() {
                return up;
            }
        }
    }
}
