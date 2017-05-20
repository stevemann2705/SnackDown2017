class SnakePoints:

    def __init__(self, x1, y1, x2, y2):
        self.x1 = int(x1)
        self.y1 = int(y1)
        self.x2 = int(x2)
        self.y2 = int(y2)
        self.spanned_points = []
        self.generate_line()

    def generate_line(self):
        x_pair = [self.x1, self.x2]
        y_pair = [self.y1, self.y2]
        self.spanned_points.append([self.x1, self.y1])
        self.spanned_points.append([self.x2, self.y2])
        if self.x1 == self.x2:
            for i in range(min(y_pair), max(y_pair)):
                self.spanned_points.append([self.x1, i])
        elif self.y1 == self.y2:
            for i in range(min(x_pair), max(x_pair)):
                self.spanned_points.append([i, self.y1])

    def _get_line_overlap_count(self, snake2):
        overlap = 0
        for x, y in self.spanned_points:
            for x2, y2 in snake2.spanned_points:
                if x == x2 and y == y2:
                    overlap += 1
        return overlap

    def _get_unique_point_count(self, snake2):
        points = [
            "{0},{1}".format(self.x1, self.y1),
            "{0},{1}".format(self.x2, self.y2),
            "{0},{1}".format(snake2.x1, snake2.y1),
            "{0},{1}".format(snake2.x2, snake2.y2)
        ]
        points = set(points) # Keep unique values
        return len(points)

    def compare_snakes(self, snake2):
        overlap = self._get_line_overlap_count(snake2)
        point_count = self._get_unique_point_count(snake2)
        if (overlap == 1 and point_count < 3) or overlap > 1:
            return True
        return False


if __name__ == "__main__":
    contents = []
    content_length = int(input()) * 2

    while content_length:
        contents.append(input())
        content_length -= 1

    for i in range(0, len(contents) - 1,  2):
        snake_definition_one = contents[i].split()
        snake_definition_two = contents[i + 1].split()
        snake_one = SnakePoints(snake_definition_one[0], snake_definition_one[1],
                                snake_definition_one[2], snake_definition_one[3])
        snake_two = SnakePoints(snake_definition_two[0], snake_definition_two[1],
                                snake_definition_two[2], snake_definition_two[3])
        if snake_one.compare_snakes(snake_two):
            print("yes")
        else:
            print("no")
